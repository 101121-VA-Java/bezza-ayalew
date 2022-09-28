import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Employee } from '../models/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private serviceUrl = 'http://localhost:8081/users';
  currentUser: any;
  token: string = "";
  constructor(private http: HttpClient) { }

  getUsers(): any{
    return this.http
    .get(this.serviceUrl)
    .pipe(map((data: any) => data));
  }

  getUserById(id: number): any{
    return this.http.get(`${this.serviceUrl}/${id}`)
    .pipe(map((data: any) => data)); 
    // {
    //   this.currentUser = JSON.stringify(data.body);
    // }));

  }

  update(user: Employee): Observable<Employee> {
    return this.http.patch<Employee>(`${this.serviceUrl}/${user.ersUserId}`, user
    );
  }
//   update(user: User) {
//   return this.http.patch<User>(`${this.serviceUrl}/${user.ersUserId}`, user, {
//     headers: {'Content-type': 'application/json'},
//     observe: 'response'
//   }).pipe(
//     map(response => {
//       let res = JSON.stringify(response.body);
//       localStorage.setItem("currentUser", res);
//     })
//   );
// }

login(data: any){
  return this.http.post(`http://localhost:8081/api/auth`, data, {
    headers: {'Content-type': 'application/json'},
    observe: 'response'
  }).pipe(
    map(response => {
      this.currentUser = JSON.stringify(response.body);
      console.log(this.currentUser);
      this.token = response.headers.get('Authorization') || '';
      localStorage.setItem("token", this.token);
      localStorage.setItem("currentUser", this.currentUser);
    })
  );
}

logout(): void {
  this.currentUser = undefined;
  this.token = '';
  localStorage.clear();
}
}
