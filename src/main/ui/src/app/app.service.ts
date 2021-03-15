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
    console.log(' checkConversion Root URL : ' + this.rootURL );
    return this.http.post(this.rootURL + '/entry', entry);
  }

    // tslint:disable-next-line: typedef
  getEntries() {
    console.log(' getEntries Root URL : ' + this.rootURL );
    return this.http.get(this.rootURL + '/listEntries');
  }

}
