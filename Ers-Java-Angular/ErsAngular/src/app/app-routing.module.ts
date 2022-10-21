
import { ManagerComponent } from './components/manager/manager.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{
  path: '',
    component: LoginComponent
},{
  path: 'manager',
    component: ManagerComponent 
},{
  path: 'employee',
    component: EmployeeComponent 
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
