import { HttpStatusCode } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
userLogin = {
  ersUsername:'',
  ersPassword:''
};
loginError = '';

  constructor(private us: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    let role = localStorage.getItem("token")?.split(":")[1];
    if(role === '3'){
      this.router.navigate(['/manager'])
    } else if(role === '2'){
      this.router.navigate(['/employee'])
    } else{
      this.router.navigate(['/'])
    }
  }

  login(): void{
    this.us.login(this.userLogin).subscribe(res =>{
      if(HttpStatusCode.Ok){
        let role = Number.parseInt(this.us.token.split(":")[1]);
        if(role === 3){
          this.router.navigate(['/manager'])
        } else if(role === 2){
          this.router.navigate(['/employee'])
        } else {
          this.router.navigate(['/'])
        };
      } else{
        console.log("cannot login");
        this.loginError = "Incorrect username and/or password!"
      }
    })
  }

}
