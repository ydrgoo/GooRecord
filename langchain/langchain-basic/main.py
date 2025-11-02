from langchain.chat_models import init_chat_model
from langchain_core.messages import HumanMessage

def main():
    ollama_model = init_chat_model("ollama:exaone-deep")
    result = ollama_model.invoke("안녕하세요!")
    result.pretty_print()


if __name__ == "__main__":
    main()
