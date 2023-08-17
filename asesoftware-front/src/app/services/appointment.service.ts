import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appointment } from '../models/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {


  private url: string = "http://localhost:8080/api";
  
  constructor(private http: HttpClient) {
  }

  confirmAppointment(app: Appointment) {
    return this.http.put(this.url + "/appointment/status/" + app.id, {status: "CONFIRMED"});
  }

  getListAppointments(startDate:string, endDate:string, service:number) {
    return this.http.get<Appointment[]>(this.url+`/appointment/agenda?start=${startDate}&end=${endDate}&service_id=${service}`)
  }
}
