import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AppService } from './app.service';
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
    this.appService.checkConversion(this.unitForm.value, this.unitCount + 1).pipe(takeUntil(this.destroy$)).subscribe(data => {
      console.log('message::::', data);
      this.unitCount = this.unitCount + 1;
      console.log(this.unitCount);
      this.unitForm.reset();
      Object.entries(data).forEach(([key, val]) => {
        if (key === 'result') {
          this.result = val;
        }
      });

    });
  }



}
