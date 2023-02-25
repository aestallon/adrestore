import { Component, Input, OnInit } from '@angular/core';
import { AddressDetail } from 'src/app/api/adrestore';

@Component({
  selector: 'app-address-form',
  templateUrl: './address-form.component.html',
  styleUrls: ['./address-form.component.css']
})
export class AddressFormComponent implements OnInit {

  @Input() addressType?: string;
  @Input() address?: AddressDetail;
  @Input() expandedByDefault?: boolean;

  constructor() { }

  ngOnInit(): void {
  }

}
