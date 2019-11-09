import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm = new FormGroup({
    email: new FormControl(),
    password: new FormControl(),
    repeatPassword: new FormControl(),
  });

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
  }

  onRegisterClicked() {
    if (this.registerForm.value.password !== this.registerForm.value.repeatPassword) {
      alert("Password and repeatPassword are different!")
    } else {
      this.authService.register(this.registerForm.value.email, this.registerForm.value.password)
    }
  }
}
