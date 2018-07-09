#include <iostream>
#include <vector>

class MinHeap{
    public:
        void insert(int v);
        void remove(int v);           
        void minHeapify();
        void print();
	int extractMin();
	int size();
	private:
	std::vector<int> data;    
        int parent(int i);
        int leftChild(int i);
        int rightChild(int i);
	void siftUp(int i);
        void siftDown(int i);
	void swap(int e, int v);        
};

int MinHeap::extractMin(){
    return this->data[0];
}

int MinHeap::size(){
    return this->data.size();
}

void MinHeap::insert(int v){
    this->data.push_back(v);
    this->siftUp(this->data.size()-1);    
}

void MinHeap::remove(int v){
    int pos;
    for (int j = 0; j < this->data.size(); j++){
        if(this->data[j] == v){
            pos = j;
            break;
        }
    }  
    this->swap(pos,this->data.size()-1);
    this->data.pop_back();
    this->siftDown(pos);
}

void MinHeap::swap(int e, int v){
    int temp = this->data[e];
    this->data[e] = this->data[v];
    this->data[v] = temp;
}

void MinHeap::siftUp(int i){
    int temp;
    while (i > 0 && this->data[this->parent(i)] > this->data[i]){        
        temp = this->data[i];
        this->swap(i, this->parent(i));
        i = this->parent(i);       
    }    
}

void MinHeap::siftDown(int i){
    int minIndex = i;
    int l = this->leftChild(i);
    int r = this->rightChild(i);
        
    if (r < this->data.size() && this->data[r] < this->data[minIndex]){
        minIndex = r;
    } 
	if (l < this->data.size() && this->data[l] < this->data[minIndex]){
        minIndex = l;
    }	
    if (i != minIndex){
        this->swap(i,minIndex);  
        this->siftDown(minIndex);		
    }
}

void MinHeap::minHeapify(){    
    for (int x = this->data.size() - 1; x > 0; x--){
        this->siftUp(x);
    }
}

int MinHeap::parent(int i){
    return (i-1)/2;
}

int MinHeap::leftChild(int i){
    return 2*i + 1;
}

int MinHeap::rightChild(int i){
    return 2*i + 2;
}

void MinHeap::print(){
    if(this->data.size() > 0){
        std::cout << "[";
        for (int x = 0; x < this->data.size()-1; x++){
            std::cout << this->data[x] << ", ";
        }
        std::cout << this->data[this->data.size()-1] << "]" << "\n";
    }
    else{
       std::cout << "Heap is empty.\n"; 
    }
}
