import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(private us: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }
  logout(){
    this.us.logout();
    this.router.navigate(['']);
  }

}
