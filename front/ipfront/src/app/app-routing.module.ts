import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponentComponent } from './login-component/login-component.component';
import { SideNavBarComponent } from './side-nav-bar/side-nav-bar.component';
import { RegistrationComponent } from './registration/registration.component';
import { ActivateComponent } from './activate/activate.component';
import { UpdateComponent } from './update/update.component';
import { MessageComponent } from './message/message.component';
import { RssFeedComponent } from './rss-feed/rss-feed.component';
import { ExersiseComponent } from './exersise/exersise.component';
import { DiaryComponent } from './diary/diary.component';
import { GraphComponent } from './graph/graph.component';
import { ProgrammsComponent } from './programms/programms.component';
import { ProgrammDetailComponent } from './programm-detail/programm-detail.component';
import { MyProgrammsComponent } from './my-programms/my-programms.component';
import { ProgrammCreateComponent } from './programm-create/programm-create.component';
import { VideoPlayerComponent } from './video-player/video-player.component';
const routes: Routes = [
  {path: '', component: LoginComponentComponent},
  {path: 'side-nav-bar', component: SideNavBarComponent},
  {path: 'registration', component: RegistrationComponent},
  {path: 'activate', component: ActivateComponent},
  {path: 'update', component: UpdateComponent},
  {path: 'message', component:MessageComponent},
  {path: 'rssFeed', component:RssFeedComponent},
  { path: 'exersise', component: ExersiseComponent},
  {path: 'diary', component:DiaryComponent},
  {path: 'graph', component:GraphComponent},
  {path: 'programm', component:ProgrammsComponent},
  {path: 'programmDetail/:id', component:ProgrammDetailComponent},
  {path: 'myProgramms', component:MyProgrammsComponent},
  {path: 'programmCreate', component:ProgrammCreateComponent},
  {path: 'videoPlayer', component: VideoPlayerComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
