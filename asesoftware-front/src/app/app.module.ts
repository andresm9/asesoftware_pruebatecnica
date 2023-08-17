import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AuthService } from './services/auth.service';
import { UserService } from './services/user.service';
import { CommerceService } from './services/commerce.service';
import { AppointmentService } from './services/appointment.service';
import { AppointmentComponent } from './appointment/appointment.component';
import { ListAppointmentsComponent } from './list-appointments/list-appointments.component';
import { FilterComponent } from './filter/filter.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    AppointmentComponent,
    ListAppointmentsComponent,
    FilterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AuthService, UserService, CommerceService, AppointmentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
