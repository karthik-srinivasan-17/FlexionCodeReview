import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  rootURL = '/api';

  // tslint:disable-next-line: typedef
  checkConversion(entry: any) {
    return this.http.post(this.rootURL + '/entry', entry);
  }

    // tslint:disable-next-line: typedef
  getEntries() {
    return this.http.get(this.rootURL + '/listEntries');
  }

}
