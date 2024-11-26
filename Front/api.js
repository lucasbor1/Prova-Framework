const URL_BASE = "http://localhost:8080";

async function listarTodos(path) {
  const resposta = await fetch(`${URL_BASE}/${path}`, {
    method: "GET",
  });

  if (!resposta.ok) {
    const erroApi = await extrairErro(resposta);
    throw new Error(erroApi);
  }

  return resposta.json();
}

async function buscarPorId(path, id) {
  const resposta = await fetch(`${URL_BASE}/${path}/${id}`, {
    method: "GET",
  });

  if (!resposta.ok) {
    const erroApi = await extrairErro(resposta);
    throw new Error(erroApi);
  }

  return resposta.json();
}

async function enviar(path, dados) {
  const resposta = await fetch(`${URL_BASE}/${path}`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(dados),
  });

  if (!resposta.ok) {
    const erroApi = await extrairErro(resposta);
    throw new Error(erroApi);
  }

  return resposta.json();
}

async function atualizar(path, id, dados) {
  const resposta = await fetch(`${URL_BASE}/${path}/${id}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(dados),
  });

  if (!resposta.ok) {
    const erroApi = await extrairErro(resposta);
    throw new Error(erroApi);
  }

  return resposta.json();
}

async function remover(path, id) {
  const resposta = await fetch(`${URL_BASE}/${path}/${id}`, {
    method: "DELETE",
  });

  if (!resposta.ok) {
    const erroApi = await extrairErro(resposta);
    throw new Error(erroApi);
  }
}

async function extrairErro(resposta) {
  try {
    const erroJson = await resposta.json();
    return erroJson.errors ? erroJson.errors : JSON.stringify(erroJson);
  } catch {
    return "Erro desconhecido.";
  }
}

export { listarTodos, buscarPorId, enviar, atualizar, remover };
