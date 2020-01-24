import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  ngOnInit() {
  }

  signupForm: FormGroup;

  createFormGroup() {
    return new FormGroup({
      name: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required]),
      address: new FormControl('', [Validators.required, Validators.required]),
      userName: new FormControl('', [Validators.required]),
      userPassword: new FormControl('', [Validators.required]),
      userEmail: new FormControl('', [Validators.required])
    });
  }

  constructor(private authService: AuthService, private router: Router) {
    this.signupForm = this.createFormGroup();
  }

  register() {
    console.log(this.signupForm.value);
    var formData = this.signupForm.value;
    var users = [{name:formData.userName,email:formData.userEmail,password:formData.userPassword}];
    formData.users = users;
    this.authService.register(formData).subscribe((res) => {
      this.router.navigateByUrl('home');
    });
  }
  public login() {
    this.router.navigate(['/login']);
  }

  public board() {
    this.router.navigate(['/board']);
  }
}
