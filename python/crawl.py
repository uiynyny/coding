import requests
from bs4 import BeautifulSoup

headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36'}

def fetch_page(url):
    try:
        response = requests.get(url,headers=headers)
        if response.status_code == 200:
            return response.text
        else:
            print("Failed to fetch page:", response.status_code)
            return None
    except Exception as e:
        print("Error fetching page:", e)
        return None

def extract_links(html_content):
    soup = BeautifulSoup(html_content, 'html.parser')
    links = []
    for link in soup.find_all('a'):
        href = link.get('href')
        if href and href.startswith("https://www.hermes.com/ca/en"):
            links.append(href)
    return links

def crawl(url, depth):
    if depth <= 0:
        return
    html_content = fetch_page(url)
    if html_content:
        links = extract_links(html_content)
        for link in links:
            print(link)
            crawl(link, depth - 1)

if __name__ == "__main__":
    start_url = "https://www.hermes.com/ca/en/category/women/bags-and-small-leather-goods/bags-and-clutches"
    max_depth = 2  # Define the maximum depth of crawling
    crawl(start_url, max_depth)
