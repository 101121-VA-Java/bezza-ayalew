import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormioAuthService } from '@formio/angular/auth';
import { FormioResources } from '@formio/angular/resource';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  // template: '<formio src="https://clxseyaefwqpgaq.form.io/magerarchiver"></formio>',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'mager-avi-archiver';

  constructor(
    public auth: FormioAuthService,
    private router: Router,
    public resources: FormioResources
  ) {
    this.auth.onLogin.subscribe(() => {
      this.router.navigate(['/']);
    });

    this.auth.onLogout.subscribe(() => {
      this.router.navigate(['/auth/login']);
    });

    this.auth.onRegister.subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}
