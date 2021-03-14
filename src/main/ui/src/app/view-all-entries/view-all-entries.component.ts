import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-view-all-entries',
  templateUrl: './view-all-entries.component.html',
  styleUrls: ['./view-all-entries.component.css']
})
export class ViewAllEntriesComponent implements OnInit {

  constructor() { }

    @Input() unitCount = 0;
  @Output() getUnitEvent = new EventEmitter();

  ngOnInit(): void {
  }

    getAllEntries() {
    this.getUnitEvent.emit('get all Units');
  }


}
