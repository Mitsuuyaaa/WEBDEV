const apiBase = "http://localhost:8000/api/products";

document.addEventListener("DOMContentLoaded", loadProducts);

async function loadProducts() {
  const res = await fetch(apiBase);
  const products = await res.json();
  const body = document.getElementById("productTableBody");
  body.innerHTML = "";
  products.forEach(p => {
    body.innerHTML += `
      <tr class="text-center">
        <td class="border p-2">${p.id}</td>
        <td class="border p-2">${p.name}</td>
        <td class="border p-2">${p.description}</td>
        <td class="border p-2">${p.stock}</td>
        <td class="border p-2">${p.unit}</td>
        <td class="border p-2">${p.price}</td>
        <td class="border p-2">
          <button onclick="editProduct(${p.id}, '${p.name}', '${p.description}', ${p.stock}, '${p.unit}', ${p.price})"
            class="bg-yellow-500 text-white px-3 py-1 rounded hover:bg-yellow-600">Edit</button>
          <button onclick="deleteProduct(${p.id})"
            class="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600">Delete</button>
        </td>
      </tr>`;
  });
}

function openModal() {
  document.getElementById("productForm").reset();
  document.getElementById("productId").value = "";
  document.getElementById("modalTitle").innerText = "Add Product";
  document.getElementById("productModal").classList.remove("hidden");
}

function closeModal() {
  document.getElementById("productModal").classList.add("hidden");
  document.getElementById("errorMsg").innerText = "";
}

function editProduct(id, name, desc, stock, unit, price) {
  document.getElementById("modalTitle").innerText = "Edit Product";
  document.getElementById("productId").value = id;
  document.getElementById("name").value = name;
  document.getElementById("description").value = desc;
  document.getElementById("stock").value = stock;
  document.getElementById("unit").value = unit;
  document.getElementById("price").value = price;
  document.getElementById("productModal").classList.remove("hidden");
}

async function saveProduct(e) {
  e.preventDefault();
  const id = document.getElementById("productId").value;
  const data = {
    name: document.getElementById("name").value,
    description: document.getElementById("description").value,
    stock: parseInt(document.getElementById("stock").value),
    unit: document.getElementById("unit").value,
    price: parseFloat(document.getElementById("price").value),
  };

  if (!data.name || !data.description || data.stock < 1 || data.price < 1) {
    document.getElementById("errorMsg").innerText = "Please fill all fields correctly.";
    return;
  }

  const method = id ? "PUT" : "POST";
  const url = id ? `${apiBase}/${id}` : apiBase;

  const res = await fetch(url, {
    method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });

  if (!res.ok) {
    const err = await res.json();
    document.getElementById("errorMsg").innerText = err.error || "Validation failed";
    return;
  }

  closeModal();
  loadProducts();
}

async function deleteProduct(id) {
  if (!confirm("Delete this product?")) return;
  await fetch(`${apiBase}/${id}`, { method: "DELETE" });
  loadProducts();
}
