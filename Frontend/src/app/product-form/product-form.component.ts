import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../product.service';
import { Product } from '../product.model';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {
  product: Product = { id: 0, name: '', price: 0, quantity: 0 };

  constructor(private productService: ProductService, private router: Router) {}

  ngOnInit(): void {}

  saveProduct(): void {
    if (this.product.id === 0) {
      this.productService.createProduct(this.product).subscribe(() => {
        this.router.navigate(['/products']);
      });
    } else {
      this.productService.updateProduct(this.product.id, this.product).subscribe(() => {
        this.router.navigate(['/products']);
      });
    }
  }
}
