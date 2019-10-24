import { Component, OnInit } from '@angular/core';
import { StudentserviceService } from '../studentservice.service';
import { Course } from '../course.model';
import { CourseserviceService } from '../courseservice.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  allStudentCourses: Course[] = [];
  allCourses: Course[] = [];
  studentId: string;
  constructor(public studentService: StudentserviceService, public courseService: CourseserviceService) { }

  ngOnInit() {
    this.studentService.currentMessage.subscribe(message => this.studentId = message);
    this.courseService.fetchCourses(this.studentId).subscribe((data)=>{
      //console.log(data);
      let dLen: number = Object.keys(data).length;
      for (let i = 0; i < dLen; i ++) {
        length = this.allStudentCourses.push(new Course(data[i].id, data[i].description));
      }
      console.log(this.allStudentCourses);
    });

    this.courseService.fetchCourseList().subscribe((data)=>{
      //console.log(data);
      let dLen: number = Object.keys(data).length;
      for (let i = 0; i < dLen; i ++) {
        length = this.allCourses.push(new Course(data[i].id, data[i].description));
      }
      console.log(this.allCourses);
    });
  }

}
