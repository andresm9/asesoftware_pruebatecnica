import { Component, OnInit } from '@angular/core';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as alertify from 'alertifyjs';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { User } from '../models/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  hasSubmitted: boolean = false;

  get username(){ return this.loginForm.get('username'); }
  get password(){ return this.loginForm.get('password'); }

  constructor(private fb: FormBuilder, private authService: AuthService, private router : Router, private UserService:UserService) {
    this.loginForm = this.fb.group({
      username : ['',[Validators.required, Validators.pattern("^[a-zA-Z0-9\-]+$")]],
      password : ['',[Validators.required, Validators.minLength(4)]]
    });
  }

  onSubmit() {
    this.hasSubmitted = true;
    //console.log(this.loginForm.value);
    const token = this.authService.authUser(this.loginForm.value);
    if (this.loginForm.valid) {
      if(token){ //if user have some value it will check and validate
        localStorage.setItem('token',token.username);
        alertify.success('You have logged in successfully');
        this.router.navigate(['/home']);
      }
      else{ //if user is null or incorrect
        alertify.error('Username or Password is wrong');
      }
      
      this.loginForm.reset();
      this.hasSubmitted = false;
    }
    else{
      alertify.error('Please fill required fields');
    }
  }


  ngOnInit(): void {

    //agregar usuario a la primera 
    if (!localStorage.getItem('users')) {
      let user: User = { username: "test", password: "test" };
      this.UserService.addUser(user);
    } else {
      console.log("User Loaded already");
    }
  }

}
