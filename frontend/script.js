let expenses = [];
let income = 0;
let nextId = 1;
let activeCategory = null;

// Modal open
document.querySelectorAll(".btn-add-expense").forEach(function (button) {
  button.addEventListener("click", function () {
    activeCategory = this.dataset.category;
    document.getElementById("modal-overlay").classList.remove("hidden");
  });
});

// Modal cancel
document.getElementById("btn-cancel").addEventListener("click", function () {
  closeModal();
});

// Modal confirm
document.getElementById("btn-confirm").addEventListener("click", function () {
  const title = document.getElementById("expense-title").value.trim();
  const description = document
    .getElementById("expense-description")
    .value.trim();
  const budget = parseFloat(document.getElementById("expense-budget").value);
  const errorEl = document.getElementById("modal-error");

  // Validation
  if (!title || !budget || budget < 0) {
    errorEl.classList.remove("hidden");
    return;
  }

  errorEl.classList.add("hidden");

  const expense = {
    id: nextId++,
    title,
    description,
    budget,
    category: activeCategory,
  };

  expenses.push(expense);
  renderExpense(expense);
  updateTotal(activeCategory);
  closeModal();
});

function renderExpense(expense) {
  const list = document.getElementById(`list-${expense.category}`);
  const li = document.createElement("li");
  li.textContent = expense.description
    ? `${expense.title} - $${expense.budget} (${expense.description})`
    : `${expense.title} - $${expense.budget}`;
  list.appendChild(li);
}

function updateTotal(category) {
  const total = expenses
    .filter((e) => e.category === category)
    .reduce((sum, e) => sum + e.budget, 0);
  document.getElementById(`total-${category}`).textContent = `Total: $${total}`;
}

function closeModal() {
  document.getElementById("modal-overlay").classList.add("hidden");
  document.getElementById("expense-title").value = "";
  document.getElementById("expense-description").value = "";
  document.getElementById("expense-budget").value = "";
  document.getElementById("modal-error").classList.add("hidden");
  activeCategory = null;
}
