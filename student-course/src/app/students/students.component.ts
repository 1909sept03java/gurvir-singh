import { Component, OnInit } from '@angular/core';
import { StudentserviceService } from '../studentservice.service';
import { Student } from '../student.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  allStudents: Student[] = [];
  id: number;

  constructor(public studentService: StudentserviceService, public router: Router) { }

  ngOnInit() {
    this.studentService.fetchStudents().subscribe((data)=>{
      //console.log(data);
      let dLen: number = Object.keys(data).length;
      for (let i = 0; i < dLen; i ++) {
        length = this.allStudents.push(new Student(data[i].id, data[i].name));
      }
      console.log(this.allStudents);
    });
  }

  checkCourse(studentId) {
    console.log(studentId);
    this.studentService.changeMessage(studentId);
    this.router.navigate(['/courses']);
  }



}
