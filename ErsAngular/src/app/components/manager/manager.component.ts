import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { Reimbursement } from 'src/app/models/reimbursement';
import { Observable } from 'rxjs';
import { DataService } from './../../services/data.service';
import { Component, OnInit, Input, Output, AfterViewInit, ViewChild } from '@angular/core';
import { User } from 'src/app/models/user';
import { Employee } from 'src/app/models/employee';
import { RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css'],
})
export class ManagerComponent implements OnInit {
  statusDescription = [
    { id: 1, name: 'pending' },
    { id: 2, name: 'approved' },
    { id: 3, name: 'rejected' },
    { id: 4, name: 'all' }
  ];
  columnsToDisplay = ['reimbId', 'reimbAmount',  'reimbDescription', 'reimbReceipt',
    'reimbResolved', 'reimbSubmitted',  'reimbAuthor', 'reimbResolver',
    'reimbStatus', 'reimbType'];
  selectedStatus = '';
  selectedReimbs: Reimbursement[] = [];
  allReimbs: Reimbursement[] = [];
  reimbById? = {};
  reimbByAuthor: Reimbursement[] = [];

  onEmpId(event: any) {
    this.getEmployeeById(event.target.value);
  }
  onReimbAuthId(event: any) {
    this.getReimbursementsByAuthorId(event.target.value);
  }
  onReimbId(event: any) {
    this.getReimbursementById(event.target.value);
  }
  
  constructor(private ds: DataService) {}

  ngOnInit(): void {}

  getReimbsByStatus(status: String) {
    console.log("here comes");
    if (status == 'all') {
      this.ds.getReimbursements().subscribe((res: any) => {
        this.selectedReimbs = res;
      });
    } else {
      this.ds.getReimbursementsByStatus(status).subscribe((res: any) => {
        this.selectedReimbs = res;
      });
    }
  }

  getReimbursementById(id: number) {
    this.ds.getReimbursementById(id).subscribe((res: any) =>{
      this.reimbById = res;
    })
  }
  getReimbursementsByAuthorId(authId: number) {
    this.ds.getReimbursementByAuthorId(authId).subscribe((res: any) => {
      this.reimbByAuthor = res;
    });
  }
  generateTable() {}
  generateTableHead() {}
  populateData() {}
  setReimbursementForUpdate() {}
  collectUpdates() {
    let reimbTableHeader = {
      reimbId: String,
      reimbAmount: String,
      reimbResolved: String,
      reimbReceipt: String,
      reimbResolver: String,
      reimbStatusId: String,
      reimbTypeId: String,
    };
  }
  commitUpdates() {}

  getAllEmployees() {}
  getEmployeeById(id: any) {}
}
