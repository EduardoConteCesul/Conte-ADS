from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
import os

chave = os.urandom(32)
nonce = os.urandom(16)

print("Chave secreta: ", chave.hex())
print("Nonce: ", nonce.hex())

mensagem = "Salveeee quebradaaaaa".encode("UTF-8")

cifra = Cipher(
    algorithms.ChaCha20(chave, nonce), 
    mode=None,
    backend=default_backend()
)

encriptador = cifra.encryptor()

mensagem_criptografada = encriptador.update(mensagem)

print("Mensagem criptografada: ", mensagem_criptografada.hex())