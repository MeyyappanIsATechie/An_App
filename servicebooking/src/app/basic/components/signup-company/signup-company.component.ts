import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-signup-company',
  templateUrl: './signup-company.component.html',
  styleUrl: './signup-company.component.scss',
})
export class SignupCompanyComponent {
  validateForm!: FormGroup;
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private notification: NzNotificationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: [null, [Validators.required]],
      address: [null, [Validators.required]],
      phone: [null],
      email: [null, [Validators.email, Validators.required]],
      password: [null, [Validators.required]],
      confirmPassword: [null, [Validators.required]],
    });
  }

  submitForm() {
    this.authService.registerCompany(this.validateForm.value).subscribe(
      (res) => {
        this.notification.success('SUCCESS', 'Signup Successful', {
          nzDuration: 5000,
        });
        this.router.navigateByUrl('/login');
      },
      (error) => {
        this.notification.error('ERROR', error.error.message, {
          nzDuration: 5000,
        });
        console.error(error);
      }
    );
  }
}
