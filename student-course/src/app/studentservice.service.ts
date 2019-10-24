import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentserviceService {

  private messageSource = new BehaviorSubject('-1');
  currentMessage = this.messageSource.asObservable();

  constructor(public httpClient: HttpClient) { }

  endpoint = 'http://localhost:8084/student/all';

  fetchStudents() {
    return this.httpClient.get(this.endpoint);

  }

  changeMessage(message: string) {
    this.messageSource.next(message)
  }

}
