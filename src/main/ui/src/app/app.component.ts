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

 
  constructor(private appService: AppService) {}
   title = 'Flexion Coding Challenge';
  unitForm = new FormGroup({
    askedValue: new FormControl('', Validators.nullValidator && Validators.required),
    fromMeasurement: new FormControl('', Validators.nullValidator && Validators.required),
    toMeasurement: new FormControl('', Validators.nullValidator && Validators.required),
    writtenValue: new FormControl('', Validators.nullValidator && Validators.required),
  });
  
  
  destroy$: Subject<boolean> = new Subject<boolean>();
    onSubmit() {
    this.appService.checkConversion(this.unitForm.value, this.unitCount + 1).pipe(takeUntil(this.destroy$)).subscribe(data => {
      console.log('message::::', data);
      this.unitCount = this.unitCount + 1;
      console.log(this.unitCount);
      this.unitForm.reset();
    });
  }

  entries: any[] = [];
   unitCount = 0;

}
