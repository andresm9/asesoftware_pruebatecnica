import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Commerce } from '../models/commerce';
import { Service } from '../models/service';

@Injectable({
  providedIn: 'root'
})
export class CommerceService {

  private url: string = "http://localhost:8080/api";
  constructor(private http: HttpClient) {
  }

  getCommerces():Observable<Commerce[]> {
    return this.http.get<Commerce[]>(this.url+"/commerces");
  }

  getServicesByCommerce(id:string) {
    return this.http.get<Service[]>(this.url + "/commerces/" + id + "/services");
  }
}
