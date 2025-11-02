# LangChain Basic

LangChain 기초 프로젝트입니다.

## 환경 설정

이 프로젝트는 [uv](https://github.com/astral-sh/uv) 패키지 매니저를 사용합니다.

### Python 인터프리터 설정

프로젝트를 VSCode 또는 Cursor에서 열 때, 다음 경로의 Python 인터프리터를 선택하세요:

```
.venv\Scripts\python.exe
```

또는 전체 경로:
```
C:\Users\ydrgoo\Documents\GitHub\GooRecord\langchain\langchain-basic\.venv\Scripts\python.exe
```

### 설정 방법

1. **Cursor/VSCode에서**:
   - `Ctrl+Shift+P`를 누르고 "Python: Select Interpreter" 선택
   - `.venv\Scripts\python.exe` 선택

2. **자동 인식이 안 될 때**:
   - `.venv` 폴더가 보이지 않으면 `uv venv` 명령어 실행
   - 프로젝트를 재로드하거나 재시작

## 의존성 설치

```bash
uv sync
```

## 실행

```bash
python main.py
```

또는

```bash
uv run main.py
```

## 요구사항

- Python >= 3.12
- uv 패키지 매니저

## 환경 변수

OpenAI API를 사용하려면 `.env` 파일에 다음을 추가하세요:

```
OPENAI_API_KEY=your_api_key_here
```
