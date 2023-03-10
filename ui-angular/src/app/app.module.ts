import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PersonComponent } from './components/person/person.component';
import { PersonCardComponent } from './components/person-card/person-card.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule} from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { ApiModule, Configuration, ConfigurationParameters } from './api/adrestore';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { AddressFormComponent } from './components/address-form/address-form.component';
import { NameFormComponent } from './components/name-form/name-form.component';

export function apiConfigFactory(): Configuration {
  const params: ConfigurationParameters = {
    basePath: environment.basePath,
  };
  return new Configuration(params);
}

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    PersonComponent,
    PersonCardComponent,
    AddressFormComponent,
    NameFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatButtonModule,
    MatIconModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatInputModule,
    MatToolbarModule,
    MatSnackBarModule,
    MatDialogModule,
    ApiModule.forRoot(apiConfigFactory),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
