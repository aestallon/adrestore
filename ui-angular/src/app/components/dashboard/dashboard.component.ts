import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { PersonDetail, PersonService } from 'src/app/api/adrestore';
import { PersonPreview } from 'src/app/api/adrestore/model/personPreview';
import { NameFormComponent } from '../name-form/name-form.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  persons?: PersonPreview[];
  detailedPerson?: PersonDetail;

  constructor(
    private service: PersonService,
    public newPersonDialog: MatDialog
    ) {}

  async ngOnInit(): Promise<void> {
    await this.loadPeople();
    // this.staticInit();
  }

  async loadPeople(): Promise<void> {
    this.persons = await this.service.getAllPersons().toPromise();
  }

  async saveNewPerson(): Promise<void> {
    let dialogRef = this.newPersonDialog.open(NameFormComponent, {
      data: {
        firstName: '',
        lastName: ''
      }
    });
    dialogRef.afterClosed().subscribe(async result => {
      if (!result.firstName || !result.lastName) {
        return;
      }
      await this.service.createPerson({
        firstName: result.firstName,
        lastName: result.lastName,
        permanentAddress: {},
        temporaryAddress: {},
      }).toPromise();
      await this.loadPeople();
    });
  }

  async loadPerson(personId: number) {
    this.detailedPerson = await this.service.getPersonById(personId).toPromise();
  }

  async deletePerson(personId: number) {
    if (this.detailedPerson && this.detailedPerson.id! === personId) {
      this.detailedPerson = undefined;
    }
    await this.service.deletePerson(personId).toPromise();
    await this.loadPeople();
  }

  closePerson() {
    this.detailedPerson = undefined;
  }


  /**
   * Only used to statically initialise the component during development.
   */
  private staticInit(): void {
    this.persons = [
      {
        id: 1,
        name: 'John Doe'
      },
      {
        id: 2,
        name: 'John With Very Long Name'
      },
      {
        id: 3,
        name: 'Xi Lao'
      },
      {
        id: 4,
        name: 'Francis Buttfoukis'
      }
    ];
    this.detailedPerson = {
      id: 1,
      firstName: 'John',
      lastName: 'Doe',
      permanentAddress: {
        id: 20,
        country: 'Hungary',
        town: 'Budapest',
        street: 'Hegyalja út',
        streetNo: 69
      },
      temporaryAddress: {
        id: 20,
        country: 'Hungary',
        town: 'Budapest',
        street: 'Hegyalja út',
        streetNo: 69
      }
    }
  }

}
