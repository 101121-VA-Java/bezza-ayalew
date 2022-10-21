import { ReimbEntries, ReimbColumns } from './../../models/reimbEntries';
import { Reimbursement } from 'src/app/models/reimbursement';
import { Employee, EmployeeColumns } from 'src/app/models/employee';
import { EmployeeService } from './../../services/employee.service';
import { DataService } from './../../services/data.service';
import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})

export class EmployeeComponent implements AfterViewInit, OnInit {
  displayedColumns: string[] = [];
  columnsSchema: any = [];

  profileDataSource = new MatTableDataSource<Employee>();
  reimbDataSource = new MatTableDataSource<ReimbEntries>();
  valid: any = {};

  id: any = localStorage.getItem('token')?.split(':')[0];
  reimbursementData: any;
  resolvedReimbursementData: Reimbursement[] = [];
  pendingReimbursementData: Reimbursement[] = [];
  reimbursementForm: Reimbursement[] = [];
  view = false;
  edit = false; 
  viewAllReimbs = false;
  viewPendingReimbs = false;
  viewResolvedReimbs = false;
  fileReimbursement = false;
  isSubmitted = false;
  
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  
  constructor(private ds: DataService, private es: EmployeeService) { }
  
  ngAfterViewInit(): void {
    this.reimbDataSource.paginator = this.paginator;
  }

  ngOnInit(){
    this.es.getUserById(this.id).subscribe((res: any) => {
    this.profileDataSource.data.push(res)});
  }
  
  viewProfile(){
    this.fileReimbursement = false;
    this.viewAllReimbs = false;
    this.viewPendingReimbs = false;
    this.viewResolvedReimbs = false;
    this.edit = false;
    this.view = true;
    this.displayedColumns = EmployeeColumns.map((col) => col.key);
    this.columnsSchema = EmployeeColumns;
    
  }

  updateProfile(){
    this.fileReimbursement = false;
    this.viewAllReimbs = false;
    this.viewPendingReimbs = false;
    this.viewResolvedReimbs = false;
    this.view = false;
    this.edit = true;
    this.displayedColumns = EmployeeColumns.map((col) => col.key);
    this.columnsSchema = EmployeeColumns;
  }

  editRow(row: Employee){
    if(row.ersUserId !=0){
      this.es.update(row).subscribe(() => (row.isEdit = false));
    }
  }
  editReimbRow(row: ReimbEntries){
      this.ds.updateReimbursement(row).subscribe(() => (row.isEdit = false));
  }

  submitReimbRow(row: ReimbEntries){
      this.ds.addReimbursement(row).subscribe(() => (row.isEdit = false));
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

  getReimbursementData() {
    this.ds.getReimbursementByAuthorId(this.id)
    .subscribe((res: any) => {
    for(const reimb of res){
      if(reimb.reimbStatus > 1)
      {
        this.resolvedReimbursementData.push(reimb);
      }else{
        this.pendingReimbursementData.push(reimb);
      }
    }
  this.reimbursementData = res});
  }

  viewAllReimbursements(){
    this.view = false;
    this.edit = false;
    this.fileReimbursement = false;
    this.viewAllReimbs = true;
    this.viewPendingReimbs = false;
    this.viewResolvedReimbs = false;
    this.reimbDataSource.data = this.reimbursementData;
    this.displayedColumns = ReimbColumns.map((col) => col.key);
    this.columnsSchema = ReimbColumns;

  }

  viewPendingReimbursements(){
    this.view = false;
    this.edit = false;
    this.fileReimbursement = false;
    this.viewAllReimbs = false;
    this.viewPendingReimbs = true;
    this.viewResolvedReimbs = false;
    this.reimbDataSource.data = this.pendingReimbursementData;
    this.reimbDataSource.data = this.pendingReimbursementData;
    this.displayedColumns = ReimbColumns.map((col) => col.key);
    this.columnsSchema = ReimbColumns;

  }

  viewResolvedReimbursements(){
    this.view = false;
    this.edit = false;
    this.fileReimbursement = false;
    this.viewAllReimbs = false;
    this.viewPendingReimbs = false;
    this.viewResolvedReimbs = true;
    this.getReimbursementData;
    this.reimbDataSource.data = this.resolvedReimbursementData;
    this.displayedColumns = ReimbColumns.map((col) => col.key);
    this.columnsSchema = ReimbColumns;

  }

  fileNewReimbursement(){
    const newReimb: ReimbEntries = {
      isSelected: false,
      reimbId: 0,
      reimbAmount: 0,
      reimbDescription: '',
      reimbReceipt: '',
      reimbResolved: new Date().toISOString().substring(0,10),  //should be null by default
      reimbSubmitted: new Date().toISOString().substring(0,10),
      reimbAuthor: this.id,
      reimbResolver: 0,
      reimbStatus: 1,
      reimbType: 0,
      isEdit: true
    }
    this.reimbDataSource.data = [newReimb];
    this.fileReimbursement = true;
    this.view = false;
    this.edit = false; 
    this.viewAllReimbs = false;
    this.viewPendingReimbs = false;
    this.viewResolvedReimbs = false;
    this.displayedColumns = ReimbColumns.map((col) => col.key);
    this.columnsSchema = ReimbColumns;
  }

}