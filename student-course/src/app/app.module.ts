import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { StudentsComponent } from './students/students.component';
import { StudentserviceService } from './studentservice.service';
import { CourseComponent } from './course/course.component';

const appRoutes: Routes = [
  { path: '',      component: StudentsComponent },
  { path: 'courses',      component: CourseComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    StudentsComponent,
    CourseComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes, {
      onSameUrlNavigation: 'reload'
    })
  ],
  providers: [StudentserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
