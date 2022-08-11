import { map } from 'rxjs';
import { ReimbEntries, ReimbColumns } from './../../models/reimbEntries';
import { Reimbursement } from 'src/app/models/reimbursement';
import { Employee, EmployeeColumns } from 'src/app/models/employee';
import { EmployeeService } from './../../services/employee.service';
import { DataService } from './../../services/data.service';
import { Component, OnInit } from '@angular/core';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDialog } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})

export class EmployeeComponent implements OnInit {
  displayedColumns: string[] = [];
  columnsSchema: any = [];
  profileDataSource = new MatTableDataSource<Employee>();
  reimbDataSource = new MatTableDataSource<ReimbEntries>();
  valid: any = {};

  id: any = localStorage.getItem('token')?.split(':')[0];
  reimbursementData: any;
  employeeProfile: any;
  resolvedReimbursementData: Reimbursement[] = [];
  pendingReimbursementData: Reimbursement[] = [];
  reimbursementForm: Reimbursement[] = [];
  view: boolean = false;
  edit: boolean = false; 
  viewAllReimbs = false;
  viewPendingReimbs = false;
  viewResolvedReimbs = false;
  fileReimbursement = false;
  
  constructor(private ds: DataService, private es: EmployeeService) { }

  ngOnInit(){
  }

  getProfile(): any{
    this.es.getUserById(this.id).subscribe((res: any) =>
      this.employeeProfile =  res);
      console.log(this.employeeProfile);
    return this.employeeProfile;
  }
  
  viewProfile(){
    this.view = true;
    this.edit = false;
    
    this.profileDataSource.data = this.employeeProfile;
    this.displayedColumns = EmployeeColumns.map((col) => col.key);
    this.columnsSchema = EmployeeColumns;
    
  }

  updateProfile(){
    this.edit = true;
    this.view = false;
    this.profileDataSource.data = this.employeeProfile;
    this.displayedColumns = EmployeeColumns.map((col) => col.key);
    this.columnsSchema = EmployeeColumns;
  }

  editRow(row: Employee){
    this.es.update(row).subscribe(() => (row.isEdit = false));
  }
  editReimbRow(row: ReimbEntries){
    this.ds.updateReimbursement(row).subscribe(() => (row.isEdit = false));
  }


  

  getReimbursementData(): any {
    this.ds.getReimbursementByAuthorId(this.id)
    .subscribe((res: any) => 
    this.reimbursementData = res);
    console.log(this.reimbursementData);
    for(const reimb of this.reimbursementData){
      if(reimb.reimbStatus > 1)
      {
        this.resolvedReimbursementData.push(reimb);
      }else{
        this.pendingReimbursementData.push(reimb);
      }
    }
    return this.reimbursementData;
  }

  inputHandler(e: any, id: number, key: string) {
    if (!this.valid[id]) {
      this.valid[id] = {};
    }
    this.valid[id][key] = e.target.validity.valid;
  }

  disableSubmit(id: number) {
    if (this.valid[id]) {
      return Object.values(this.valid[id]).some((item) => item === false);
    }
    return false;
  }

  viewAllReimbursements(){
    this.viewAllReimbs = true;
    this.viewPendingReimbs = false;
    this.viewResolvedReimbs = false;
    this.reimbDataSource.data = this.getReimbursementData();
    this.displayedColumns = ReimbColumns.map((col) => col.key);
    this.columnsSchema = ReimbColumns;

  }

  viewPendingReimbursements(){
    this.viewAllReimbs = false;
    this.viewPendingReimbs = true;
    this.viewResolvedReimbs = false;
    this.reimbDataSource.data = this.getReimbursementData();
    this.reimbDataSource.data = this.pendingReimbursementData;
    this.displayedColumns = ReimbColumns.map((col) => col.key);
    this.columnsSchema = ReimbColumns;

  }

  viewResolvedReimbursements(){
    this.viewAllReimbs = false;
    this.viewPendingReimbs = false;
    this.viewResolvedReimbs = true;
    this.getReimbursementData;
    this.reimbDataSource.data = this.resolvedReimbursementData;
    this.displayedColumns = ReimbColumns.map((col) => col.key);
    this.columnsSchema = ReimbColumns;

  }

  fileNewReimbursement(){
    this.fileReimbursement = true;
    const newReimb: ReimbEntries = {
      reimbId: 0,
      reimbAmount: 0,
      reimbDescription: '',
      reimbReceipt: '',
      reimbResolved: new Date(),  //should be null by default
      reimbSubmitted: new Date(),
      reimbAuthor: 0,
      reimbResolver: 0,
      reimbStatus: 0,
      reimbType: 0,
      isEdit: true,
      isSelected: false
    }
    this.reimbDataSource.data = [newReimb];
    this.displayedColumns = ReimbColumns.map((col) => col.key);
    this.columnsSchema = ReimbColumns;
  }

}