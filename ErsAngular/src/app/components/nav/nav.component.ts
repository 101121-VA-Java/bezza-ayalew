import { Component, Input, Output, OnInit, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/services/employee.service';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  disableManager = false;
  @Output() managerEvent = new EventEmitter<boolean>;

  constructor(private us: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    let role = localStorage.getItem("token")?.split(":")[1];
    if(role != '3'){
      this.disableManager = true;
    console.log(this.disableManager);
    this.managerEvent.emit(this.disableManager);
    }
  }
  logout(){
    this.us.logout();
    // this.router.navigate(['']);
  }

}
