import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CourseserviceService {

  constructor(public httpClient: HttpClient) { }

  endpoint = 'http://localhost:8084/course/studentCourses?id=';
  cEndpoint = 'http://localhost:8084/course/all'

  fetchCourses(id) {
    this.endpoint = this.endpoint + id;
    console.log(this.endpoint);
    return this.httpClient.get(this.endpoint);

  }

  fetchCourseList() {
    return this.httpClient.get(this.cEndpoint);

  }


}
