import { Component, OnInit } from '@angular/core';
import { PersonDetail } from 'src/app/api/adrestore';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  personDetail?: PersonDetail;
  constructor() { }

  ngOnInit(): void {
    this.personDetail = {
      id: 1,
      firstName: 'John',
      lastName: 'Doe',
      permanentAddress: {

      },
      temporaryAddress: {

      }
    }
  }

}
