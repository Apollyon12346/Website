let income = 0;
let categoryTotals = { bills: 0, groceries: 0, other: 0 };

// Income
document.getElementById("income-btn").addEventListener("click", function () {
  const value = parseFloat(document.getElementById("income-input").value);
  if (!value || value <= 0) return;
  income = value;
  document.getElementById("income-display").textContent =
    `Monthly Income: $${income}`;
});

// Submit
document.querySelectorAll(".btn-submit").forEach(function (button) {
  button.addEventListener("click", function () {
    const category = this.dataset.category;
    const column = document.querySelector(
      `.category-column[data-category="${category}"]`,
    );
    const rows = column.querySelectorAll(".expense-row");
    const errorEl = document.getElementById(`error-${category}`);

    const names = [];
    const descs = [];
    const budgets = [];

    let valid = true;

    rows.forEach(function (row) {
      const name = row.querySelector(".input-name").value.trim();
      const desc = row.querySelector(".input-desc").value.trim();
      const budget = parseFloat(row.querySelector(".input-budget").value);

      if (!name || !budget || budget < 0) valid = false;

      names.push(name);
      descs.push(desc);
      budgets.push(budget || 0);
    });

    if (!valid) {
      errorEl.classList.remove("hidden");
      return;
    }

    errorEl.classList.add("hidden");

    const total = budgets.reduce((sum, b) => sum + b, 0);
    categoryTotals[category] = total;
    document.getElementById(`total-${category}`).textContent =
      `Total: $${total}`;

    const payload = {
      categoryName: category,
      categoryName1: names[0],
      description1: descs[0],
      budgetcat1: budgets[0],
      categoryName2: names[1],
      description2: descs[1],
      budgetcat2: budgets[1],
      categoryName3: names[2],
      description3: descs[2],
      budgetcat3: budgets[2],
      totalbudget: total,
    };

    console.log("Sending to backend:", payload);

    //backend

    fetch("http://localhost:8080/api/v1/budget", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(payload),
    })
      .then((res) => res.json())
      .then((data) => console.log("Response:", data))
      .catch((err) => console.error("Error:", err));
  });
});

// Calculate leftover
document.getElementById("btn-calculate").addEventListener("click", function () {
  const totalExpenses = Object.values(categoryTotals).reduce(
    (sum, t) => sum + t,
    0,
  );
  const leftover = income - totalExpenses;
  const display = document.getElementById("leftover-display");
  display.textContent = `Amount Leftover: $${leftover.toFixed(2)}`;
  display.style.color = leftover >= 0 ? "green" : "red";
});
