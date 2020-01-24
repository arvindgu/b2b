import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  ngOnInit(): void {
  }

  loginForm: FormGroup;

  createFormGroup() {
    return new FormGroup({
      name: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }

  constructor(private authService: AuthService, private router: Router) {
    this.loginForm = this.createFormGroup();
  }

  login() {
    console.log(this.loginForm.value);
    this.authService.signIn(this.loginForm.value).subscribe((res) => {
      console.log("Logged in!");
      this.router.navigateByUrl('home');
    });
  }

  public signup() {
    this.router.navigate(['/signup']);
  }

  public login() {
    this.router.navigate(['/board']);
  }

}
