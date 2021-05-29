import {Component, OnDestroy, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Category} from '../../models/category';
import {CategoryService} from '../../services/category.service'
import {InteractionService} from '../../services/interaction.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit, OnDestroy {

  isOpen = false;

  categories: Category[];

  private alive: boolean = true;

  constructor(private categoryService: CategoryService,
              private interact: InteractionService,
              private router: Router) { }

  ngOnInit() {
    this.getCategories();
    this.subscribeCategoryListChanged();
    this.interact._categoryTabToggled
      //.takeWhile(() => this.alive)
      .subscribe(() => {
        this.isOpen = !this.isOpen;
      })
  }

  getCategories() {
    this.categoryService.findAll()
    //  .takeWhile(() => this.alive)
      .subscribe((res) => {
        this.categories = res;
      });
  }

  changeCategory(category) {
    if (category) {
      this.interact.categoryChange(category);
      this.isOpen = false;
      this.router.navigate(['/auctions', {category: category}]);
    }
  }

  subscribeCategoryListChanged() {
    this.interact._categoryListChanged
     // .takeWhile(() => this.alive)
      .subscribe(() => {
        this.getCategories();
      })
  }

  ngOnDestroy() {
    this.alive = false;
  }

}
