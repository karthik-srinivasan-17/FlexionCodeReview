import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  rootURL = '/api';

  checkConversion(entry: any, id: number) {
	entry.id = id;
	return this.http.post(this.rootURL + '/entry', entry);
  }

}
