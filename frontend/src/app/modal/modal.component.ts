import { Component, EventEmitter, Output } from '@angular/core';
import { GlobalServiceService } from '../global-service.service';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {
  @Output() close = new EventEmitter<void>();
  @Output() add = new EventEmitter<{ product: string; ratePlan: string }>();

  products: Array<any> = [];
  ratePlans: Array<any> = [];

  selectedProductUidpk: number;
  selectedRatePlanUidpk: number;

  constructor(private globalServiceService: GlobalServiceService) {}

  ngOnInit() {
    this.globalServiceService.usermanagementCalling().subscribe(
      (data: { productList: Array<any>}) => {
        this.products = data.productList;
        this.selectedProductUidpk = data.productList[0].uidpk;
      });

    this.globalServiceService.getAllRatePlans().subscribe(
      (data: Array<any>) => {
        this.ratePlans = data;
        this.selectedRatePlanUidpk = data[0].uidpk;
      });
  }

  onClose() {
    this.close.emit();
  }

  onAdd() {
    let selectedProduct = this.products.find(product => product.uidpk == this.selectedProductUidpk);
    let selectedRatePlan = this.ratePlans.find(ratePlan => ratePlan.uidpk == this.selectedRatePlanUidpk);
    this.globalServiceService.associateProductWithRatePlan(selectedProduct, selectedRatePlan)
    .subscribe(response => {
        this.add.emit({
          product: selectedProduct.productDispName,
          ratePlan: selectedRatePlan.uidpk
        });
    });
  }
}
