import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NoUrlComponent } from './no-url/no-url.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { BoardComponent } from './board/board.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'board', component: BoardComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', component: NoUrlComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
