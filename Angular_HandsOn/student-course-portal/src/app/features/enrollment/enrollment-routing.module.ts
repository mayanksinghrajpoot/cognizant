import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EnrollmentForm } from '../../pages/enrollment-form/enrollment-form.component';
import { ReactiveEnrollmentForm } from '../../pages/reactive-enrollment-form/reactive-enrollment-form.component';
import { authGuard } from '../../guards/auth.guard';
import { unsavedChangesGuard } from '../../guards/unsaved-changes.guard';

const routes: Routes = [
  { path: '', component: EnrollmentForm, canActivate: [authGuard] },
  { path: 'reactive', component: ReactiveEnrollmentForm, canActivate: [authGuard], canDeactivate: [unsavedChangesGuard] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EnrollmentRoutingModule {}

