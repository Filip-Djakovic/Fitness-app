import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { FormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { LoginComponentComponent } from './login-component/login-component.component';
import { SideNavBarComponent } from './side-nav-bar/side-nav-bar.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { RegistrationComponent } from './registration/registration.component';
import { ActivateComponent } from './activate/activate.component';
import { UpdateComponent } from './update/update.component';
import { MessageComponent } from './message/message.component';
import { RssFeedComponent } from './rss-feed/rss-feed.component';
import { MatChipsModule } from '@angular/material/chips';
import { ExersiseComponent } from './exersise/exersise.component';
import { DiaryComponent } from './diary/diary.component';
import { GraphComponent } from './graph/graph.component';
import { ProgrammsComponent } from './programms/programms.component';
import { ProgrammDetailComponent } from './programm-detail/programm-detail.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MyProgrammsComponent } from './my-programms/my-programms.component';
import { ProgrammCreateComponent } from './programm-create/programm-create.component';
import { MatSelectModule } from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';
import { VideoPlayerComponent } from './video-player/video-player.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponentComponent,
    SideNavBarComponent,
    RegistrationComponent,
    ActivateComponent,
    UpdateComponent,
    MessageComponent,
    RssFeedComponent,
    ExersiseComponent,
    DiaryComponent,
    ProgrammsComponent,
    ProgrammDetailComponent,
    MyProgrammsComponent,
    ProgrammCreateComponent,
    VideoPlayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    HttpClientModule,
    MatChipsModule,
    MatPaginatorModule,
    MatSelectModule ,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
