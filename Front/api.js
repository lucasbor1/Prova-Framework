const URL_BASE = "http://localhost:8080"; 


async function listarTodos(path) {
    const resposta = await fetch(`${URL_BASE}/${path}`, {
        method: "GET",
    });

    if (!resposta.ok) {
        throw new Error(`Erro ao listar todos: ${resposta.status}`);
    }

    return resposta.json();
}


async function buscarPorId(path, id) {
    const resposta = await fetch(`${URL_BASE}/${path}/${id}`, {
        method: "GET",
    });

    if (!resposta.ok) {
        throw new Error(`Erro ao buscar por id: ${resposta.status}`);
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
        throw new Error(`Erro ao enviar: ${resposta.status}`);
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
        throw new Error(`Erro ao atualizar: ${resposta.status}`);
    }

    return resposta.json();
}


async function remover(path, id) {
    const resposta = await fetch(`${URL_BASE}/${path}/${id}`, {
        method: "DELETE",
    });

    if (!resposta.ok) {
        throw new Error(`Erro ao deletar: ${resposta.status}`);
    }
}

export { listarTodos, buscarPorId, enviar, atualizar, remover };
