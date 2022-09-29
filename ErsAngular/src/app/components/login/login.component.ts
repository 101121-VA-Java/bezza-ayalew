import { NavComponent } from './../nav/nav.component';
import { HttpStatusCode } from '@angular/common/http';
import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit, AfterViewInit {
userLogin = {
  ersUsername:'',
  ersPassword:''
};
loginError = '';
disableManager = false;
@ViewChild(NavComponent) nav: any;

  constructor(private us: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }

  ngAfterViewInit() {  
    this.disableManager = this.nav.disableManager;
    console.log(this.disableManager);  
    }

  receiveRole($event: boolean){
    this.disableManager = $event;
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
