import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Product } from '../product.model';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getProducts().subscribe(data => {
      console.log('Products loaded:', data);  // Log for debugging
      this.products = data;
    }, error => {
      console.error('Error loading products:', error);  // Log for debugging
    });
  }

  deleteProduct(id: number): void {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(id).subscribe(() => {
        this.loadProducts();
      }, error => {
        console.error('Error deleting product:', error);
        alert('There was an error deleting the product. Please try again later.');
      });
    }
  }

  getProducts(id: number) {
    console.log('View product', id);
  }

  updateProduct(id: number) {
    console.log('Edit product', id);
  }
}
