import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';

import { HttpClientModule } from '@angular/common/http';
import { LoginModule } from './login/login.module';
import { NoUrlComponent } from './no-url/no-url.component'
import { SignupModule } from './signup/signup.module';
import { BoardModule } from './board/board.module';
import {DndModule} from 'ng2-dnd';

@NgModule({
  declarations: [
    AppComponent,
    NoUrlComponent,
  ],
  imports: [
    BrowserModule,
    DndModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    LoginModule,
    SignupModule,
    AngularFontAwesomeModule,
    BoardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
