import os
import transformers
import torch

from langchain_community.llms.huggingface_pipeline import HuggingFacePipeline
from langchain_core.prompts import PromptTemplate
from langchain.chains.llm import LLMChain
from langchain.document_loaders.pdf import PyPDFDirectoryLoader
from langchain_text_splitters import RecursiveCharacterTextSplitter
from langchain.schema.document import Document

DATA_PATH = os.path.join(os.path.dirname(__file__), "docs")


def load_documents():
    document_loader = PyPDFDirectoryLoader(DATA_PATH)
    return document_loader.load()


documents = load_documents()


def split_documents(documents: list[Document]) -> list[Document]:
    splitter = RecursiveCharacterTextSplitter(
        chunk_size=800,
        chunk_overlap=80,
        length_function=len,
        is_separator_regex=False,
    )
    return splitter.split_documents(documents)


chunks = split_documents(documents)
print(chunks[0])

from langchain_community.embeddings.bedrock import BedrockEmbeddings


def get_embedding_function():
    e = BedrockEmbeddings(credentials_profile_name="default", region_name="us-west-2")
    return e



"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"
model_id = "meta-llama/Meta-Llama-3.1-8B-Instruct"

pipeline = transformers.pipeline(
    "text-generation",
    model=model_id,
    model_kwargs={"torch_dtype": torch.bfloat16},
    device_map="auto",
    max_length=50,
)

prompt = PromptTemplate.from_template("Tell me about {entity} in short")
llm = HuggingFacePipeline(pipeline=pipeline)
chain = LLMChain(llm=llm, prompt=prompt)


# res = chain.invoke("Omega-3 Fatty Acids")
# print(res)
