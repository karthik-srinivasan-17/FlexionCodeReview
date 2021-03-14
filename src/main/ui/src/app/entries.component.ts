import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-entries',
  templateUrl: './entries.component.html',
  styleUrls: ['./entries.component.css']
})
export class EntriesComponent implements OnInit {

  constructor() {

  }

  @Input() entries: any[] | undefined;

  ngOnInit(): void {
  }

}
