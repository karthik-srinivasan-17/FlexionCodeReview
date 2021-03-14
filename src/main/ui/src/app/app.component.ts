import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AppService } from './app.service';
import { Entries } from './entries.model';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private appService: AppService) { }


  // temperature: any = ['FAHRENHEIT', 'KELVIN', 'CELSIUS', 'RANKINE'];
  type: any = ['TEMPERATURE', 'VOLUME'];
  // volume: any = ['LITER', 'TABLESPOON', 'CUBICINCH', 'CUP', 'CUBICFEET', 'GALLON'];
  entries: any[] = [];
  dropdown: any = [];
  unitCount = 0;
  result = '';
  title = 'Flexion Coding Challenge';
  unitForm = new FormGroup({
    conversionType: new FormControl('', Validators.nullValidator && Validators.required),
    askedValue: new FormControl('', Validators.nullValidator && Validators.required),
    fromMeasurement: new FormControl('', Validators.nullValidator && Validators.required),
    toMeasurement: new FormControl('', Validators.nullValidator && Validators.required),
    writtenValue: new FormControl('', Validators.nullValidator && Validators.required),
    result: new FormControl(''),
  });


  destroy$: Subject<boolean> = new Subject<boolean>();

  // tslint:disable-next-line: typedef
  changeUnit(e: any) {

    console.log(e.target.value);
    if (e.target.value === 'TEMPERATURE') {
      this.dropdown = ['FAHRENHEIT', 'KELVIN', 'CELSIUS', 'RANKINE'];
    } else {
      this.dropdown = ['LITER', 'TABLESPOON', 'CUBICINCH', 'CUP', 'CUBICFEET', 'GALLON'];
    }
  }
  // tslint:disable-next-line: typedef
  onSubmit() {
    this.result = '';
    this.appService.checkConversion(this.unitForm.value).pipe(takeUntil(this.destroy$)).subscribe(data => {
      this.unitForm.reset();
      this.unitCount++;
      Object.entries(data).forEach(([key, val]) => {
        if (key === 'result') {
          this.result = val;
        }
      });

    });
  }

  // tslint:disable-next-line: typedef
  getAllEntries() {
    this.unitCount = 0;
    this.entries = [];
    this.appService.getEntries().pipe(takeUntil(this.destroy$)).subscribe(data => {

      Object.entries(data).forEach((val) => {
        this.unitCount++;
        this.entries.push(val[1]);
      });

    });

  }

  // tslint:disable-next-line: use-lifecycle-interface
  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
    this.unitForm.reset();
  }
  // tslint:disable-next-line: use-lifecycle-interface
  ngOnInit() {
    this.getAllEntries();
    this.unitForm.reset();
  }

}
